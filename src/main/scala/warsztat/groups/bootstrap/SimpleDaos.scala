package warsztat.groups.bootstrap

import warsztat.groups.dao.SimpleGroupDao

trait SimpleDaos extends Daos {

  override def groupDao = new SimpleGroupDao

}
