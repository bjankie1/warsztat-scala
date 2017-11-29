package warsztat.groups.bootstrap

import warsztat.groups.endpoints.GroupRoute

trait Api { self: Services =>

  val routes = new GroupRoute(groupService).routes

}
