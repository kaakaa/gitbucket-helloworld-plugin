package gitbucket.hello.controller

import gitbucket.core.controller.ControllerBase
import gitbucket.hello.html

class HelloWorldController extends HelloWorldControllerBase

trait HelloWorldControllerBase extends ControllerBase {
  get("/hello") {
    html.hello("World")      
  }

  get("/hello/:name") {
    html.hello(params("name"))
  }
}
