package warsztat.groups.domain

import java.util.UUID

case class Group(id: UUID, name: String, users: Set[UUID])
