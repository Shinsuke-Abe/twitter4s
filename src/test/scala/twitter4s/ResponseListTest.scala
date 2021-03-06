package twitter4s

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import Twitter4sTestHelper._
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ResponseListTest extends Specification {
  "apply with index parameter" should {
    "get twitter4j object in list" in {
      val responseList = twitter1.getAvailableTrends()
      responseList(0) must beAnInstanceOf[twitter4j.Location]
    }
  }
  
  "ResponseList class" should {
    "has rateLimitStatus" in {
      val responseList = twitter1.getAvailableTrends()
      responseList.rateLimitStatus must beAnInstanceOf[RateLimitStatus]
    }
    
    "has accessLevel" in {
      val responseList = twitter1.getAvailableTrends()
      responseList.accessLevel must equalTo(TwitterResponse.NULL_HTTP_RESPONSE)
    }
    
    "has tw4jObj is instance of twitter4j.ResponseList" in {
      val responseList = twitter1.getAvailableTrends().tw4jObj
      responseList must beAnInstanceOf[twitter4j.ResponseList[twitter4j.Location]]
    }
  }
}