import gitbucket.hello.controller.HelloWorldController
import gitbucket.core.plugin.PluginRegistry
import gitbucket.core.util.Version
import java.io.File

class Plugin extends gitbucket.core.plugin.Plugin {
  override val pluginId: String = "helloworld"
  override val pluginName: String = "HelloWorld Plugin"
  override val description: String = "Provides HelloWorld on GitBucket."
  override val versions: List[Version] = List(Version(1, 0))

  override def initialize(registry: PluginRegistry): Unit = {
    // Add Snippet link to the header
    registry.addJavaScript(".*",
      """
        |$('a.brand').after($('<span style="float: left; margin-top: 10px;">|&nbsp;&nbsp;&nbsp;&nbsp;<a href="/hello" style="color: black;">HelloWorld&nbsp;&nbsp;&nbsp;&nbsp;</a></span>'));
      """.stripMargin)

    // Mount controller
    registry.addController(new HelloWorldController, "/*")

    println("-- HelloWorld plug-in initialized --")
  }

  override def shutdown(registry: PluginRegistry): Unit = {
  }
}
