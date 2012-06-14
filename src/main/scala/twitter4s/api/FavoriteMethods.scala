package twitter4s.api

import twitter4j.Paging
import twitter4s.ResponseList
import twitter4j.Status

/**
 * @author Shinsuke Abe - mao.instantlife at gmail.com
 */
trait FavoriteMethods {
  // TODO コメント
  /**
   * Returns the 20 most recent favorite statuses for the authenticating user or user specified by the ID parameter in the requested format.
   * <br/>This method calls one of below twitter4j api methods
   * <br/>
   * <ul>
   * <li>twitter4j.Twitter.getFavorites()</li>
   * <li>twitter4j.Twitter.getFavorites(page)</li>
   * <li>twitter4j.Twitter.getFavorites(id)</li>
   * <li>twitter4j.Twitter.getFavorites(id, page)</li>
   * <li>twitter4j.Twitter.getFavorites(paging)</li>
   * <li>twitter4j.Twitter.getFavorites(id, paging)</li>
   * </ul>
   * <br/>getFavorites method calls http://api.twitter.com/1/favorites.json
   * 
   * @param page (optional) the number of page
   * @param id (optional) the ID or screen name of the user for whom to request a list of favorite statuses
   * @param paging (optional) controls pagination. Supports sinceId and page parameters.
   * @return List<Status>
   * @throws TwitterException when Twitter service or network is unavailable
   * @see <a href="https://dev.twitter.com/docs/api/1/get/favorites">GET favorites | Twitter Developers</a>
   * @since Twitter4S 1.0.0
   */
  def getFavorites(id: Option[String] = None, page: Option[Int] = None, paging: Option[Paging] = None): ResponseList[Status]

  /**
   * Favorites the status specified in the ID parameter as the authenticating user. Returns the favorite status when successful.
   * <br/>This method calls twitter4j.Twitter.createFavorite(id)
   * <br/>createFavorite calls http://api.twitter.com/1/favorites/create/[id].json
   *
   * @param id the ID of the status to favorite
   * @return Status
   * @throws TwitterException when Twitter service or network is unavailable
   * @see <a href="https://dev.twitter.com/docs/api/1/post/favorites/create/:id">POST favorites/create/:id | Twitter Developers</a>
   * @since Twitter4S 1.0.0
   */
  def createFavorite(id: Long): Status

  /**
   * Un-favorites the status specified in the ID parameter as the authenticating user. Returns the un-favorited status in the requested format when successful.
   * <br/>This method calls twitter4j.Twitter.destroyFavorite(id)
   * <br/>This method calls http://api.twitter.com/1/favorites/destroy/[id].json
   *
   * @param id the ID of the status to un-favorite
   * @return Status
   * @throws TwitterException when Twitter service or network is unavailable
   * @see <a href="https://dev.twitter.com/docs/api/1/post/favorites/destroy/:id">POST favorites/destroy/:id | Twitter Developers</a>
   * @since Twitter4S 1.0.0
   */
  def destroyFavorite(id: Long): Status
}