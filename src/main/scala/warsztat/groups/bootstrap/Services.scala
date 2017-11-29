package warsztat.groups.bootstrap

import warsztat.groups.services.GroupService

trait Services { self: Daos =>

  lazy val groupService: GroupService = new GroupService(groupDao)

}
