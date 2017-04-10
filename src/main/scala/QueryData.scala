import com.datastax.driver.core.Cluster
import org.apache.log4j.Logger

class QueryData {

  val cluster = Cluster.builder().addContactPoint("127.0.0.1").build()
  val session = cluster.connect("database")
  val log = Logger.getLogger(classOf[QueryData])

  def findUserByEmail(email:String) = {
    val result = session.execute(s"SELECT * FROM user WHERE email='$email'")
    val iterate = result.iterator()
    while (iterate.hasNext) {
      log.info(iterate.next())
    }
  }

  def findVideoByName(name:String) = {
    val result = session.execute(s"SELECT * FROM findvideobyname WHERE video_name='$name'")
    val iterate = result.iterator()
    while (iterate.hasNext) {
      log.info(iterate.next())
    }
  }

  def videoUploaded(id:Int,year:Int) = {
    val result = session.execute(s"SELECT * FROM videouploaded WHERE userid=$id AND year>$year")
    val iterate = result.iterator()
    while (iterate.hasNext) {
      log.info(iterate.next())
    }
  }

  def videoByUserId(id:Int,year:Int) = {
    val result = session.execute(s"SELECT * FROM videobyuserid WHERE userid=$id AND year>$year ORDER BY year DESC")
    val iterate = result.iterator()
    while (iterate.hasNext) {
      log.info(iterate.next())
    }
    cluster.close()
  }

}
