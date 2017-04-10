object Main extends App{

  val data=new QueryData
  data.findUserByEmail("charmy.garg@gmail.com")
  data.findVideoByName("Cassandra")
  data.videoUploaded(10,2016)
  data.videoByUserId(10,2016)

}
