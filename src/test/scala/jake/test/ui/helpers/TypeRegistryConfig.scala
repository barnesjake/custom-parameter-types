package jake.test.ui.helpers

import java.lang.reflect.Type
import java.util
import java.util.Locale

import io.cucumber.core.api.{TypeRegistry, TypeRegistryConfigurer}
import io.cucumber.cucumberexpressions.{ParameterByTypeTransformer, ParameterType, Transformer}
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper
import io.cucumber.datatable.{TableCellByTypeTransformer, TableEntryByTypeTransformer}
import jake.test.ui.helpers.TypesToRegister.Animal

class TypeRegistryConfig extends TypeRegistryConfigurer {

  private class DefaultTransformer
    extends ParameterByTypeTransformer
      with TableEntryByTypeTransformer
      with TableCellByTypeTransformer {

    var objectMapper: ObjectMapper = new ObjectMapper()

    override def transform(s: String, `type`: Type): AnyRef =
      objectMapper.convertValue(s, objectMapper.constructType(`type`))


    override def transform[T](s: String, aClass: Class[T]): T =
      objectMapper.convertValue(s, aClass)

    override def transform[T](map: util.Map[String, String],
                              aClass: Class[T],
                              tableCellByTypeTransformer: TableCellByTypeTransformer): T =
      objectMapper.convertValue(map, aClass)
  }

  override def locale(): Locale = Locale.ENGLISH

  private val animalTransformer = new Transformer[Animal]() {
    def transform(name: String): Animal = Animal(name)
  }

  override def configureTypeRegistry(typeRegistry: TypeRegistry): Unit = {
    val defaultTransformer = new DefaultTransformer()
    typeRegistry.setDefaultDataTableCellTransformer(defaultTransformer)
    typeRegistry.setDefaultDataTableEntryTransformer(defaultTransformer)
    typeRegistry.setDefaultParameterTransformer(defaultTransformer)

    typeRegistry.defineParameterType(new ParameterType[Animal](
      "animal",
      ".+",
      classOf[Animal],
      animalTransformer
    ))

  }


}
