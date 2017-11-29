package warsztat.groups.bootstrap

object Runner
    extends App
    with SimpleDaos
    with Services
    with Api
    with WebServer {

  start()

}
