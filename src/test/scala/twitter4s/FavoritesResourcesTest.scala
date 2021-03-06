package twitter4s
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import twitter4s.mocked.FakeValuesUsedByMock

@RunWith(classOf[JUnitRunner])
class FavoritesResourcesTest extends Specification with TwitterResourcesTestBase {
  // mocking methods
  mockedTwitter4j.createFavorite(anyLong) returns FakeValuesUsedByMock.status
  mockedTwitter4j.getFavorites(anyString) returns FakeValuesUsedByMock.responseList[twitter4j.Status]
  mockedTwitter4j.getFavorites(anyString, any[twitter4j.Paging]) returns FakeValuesUsedByMock.responseList[twitter4j.Status]
  mockedTwitter4j.getFavorites(anyLong) returns FakeValuesUsedByMock.responseList[twitter4j.Status]
  mockedTwitter4j.getFavorites(anyLong, any[twitter4j.Paging]) returns FakeValuesUsedByMock.responseList[twitter4j.Status]
  mockedTwitter4j.getFavorites(any[twitter4j.Paging]) returns FakeValuesUsedByMock.responseList[twitter4j.Status]
  mockedTwitter4j.destroyFavorite(anyLong) returns FakeValuesUsedByMock.status
  
  "createFavorite" should {
    "call twitter4j createFavorite method" in {
      twitter.favorites.createFavorite(1L).text must equalTo(FakeValuesUsedByMock.statusText)
      there was one(mockedTwitter4j).createFavorite(1L)
    }
  }

  "getFavorites" should {
    "call twitter4j getFavorites method by screen name without paging" in {
      twitter.favorites.getFavorites(User.isSpecifiedBy(FakeValuesUsedByMock.userName)).size must equalTo(1)
      there was one(mockedTwitter4j).getFavorites(FakeValuesUsedByMock.userName)
    }

    "call twitter4j getFavorites method by screen name and paging" in {
      twitter.favorites.getFavorites(User.isSpecifiedBy(FakeValuesUsedByMock.userName), Paging(2)).size must equalTo(1)
      there was one(mockedTwitter4j).getFavorites(FakeValuesUsedByMock.userName, Paging(2))
    }

    "call twitter4j getFavorites method by user id without paging" in {
      twitter.favorites.getFavorites(User.isSpecifiedBy(3L)).size must equalTo(1)
      there was one(mockedTwitter4j).getFavorites(3L)
    }

    "call twitter4j getFavorites method by user id and paging" in {
      twitter.favorites.getFavorites(User.isSpecifiedBy(4L), Paging(5)).size must equalTo(1)
      there was one(mockedTwitter4j).getFavorites(4L, Paging(5))
    }

    "call twitter4j getFavorites method by paging only" in {
      twitter.favorites.getFavorites(paging= Paging(6)).size must equalTo(1)
      there was one(mockedTwitter4j).getFavorites(Paging(6))
    }
  }

  "destroyFavorites" should {
    "call twitter4j destroyFavorites method" in {
      twitter.favorites.destroyFavorite(7L).text must equalTo(FakeValuesUsedByMock.statusText)
      there was one(mockedTwitter4j).destroyFavorite(7L)
    }
  }
}