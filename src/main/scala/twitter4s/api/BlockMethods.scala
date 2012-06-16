package twitter4s.api

import twitter4j.User
import twitter4s.ResponseList
import twitter4j.IDs

trait BlockMethods {
  /**
   * Blocks the user specified in the ID parameter as the authenticating user. Returns the blocked user in the requested format when successful.
   * <br/>This method calls twitter4j.Twitter.createBlock(screenName) or createBlock(userId)
   * <br/>createBlock calls http://api.twitter.com/1/blocks/create/[id].json
   *
   * @param screenName (optional) the screen_name of the user to block
   * @param userId (optional) the ID of the user to block
   * @return the blocked user
   * @throws TwitterException when Twitter service or network is unavailable
   * @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/create">POST blocks/create | Twitter Developers</a>
   * @since Twitter4S 1.0.0
   */
  def createBlock(screenName: Option[String] = None, userId: Option[Long] = None): User

  /**
   * Un-blocks the user specified in the ID parameter as the authenticating user. Returns the un-blocked user in the requested format when successful.
   * <br/>This method calls twitter4j.Twitter.destroyBlock(screenName) or destroyBlock(userId)
   * <br/>destroyBlock calls http://api.twitter.com/1/blocks/destroy/[id].json
   *
   * @param screen_name (optional) the screen_name of the user to block
   * @param userId (optional) the ID of the user to block
   * @return the unblocked user
   * @throws TwitterException when Twitter service or network is unavailable
   * @see <a href="https://dev.twitter.com/docs/api/1/post/blocks/destroy">POST blocks/destroy | Twitter Developers</a>
   * @since Twitter4S 1.0.0
   */
  def destroyBlock(screenName: Option[String] = None, userId: Option[Long] = None): User

  /**
   * Returns if the authenticating user is blocking a target user. Will return the blocked user's object if a block exists, and error with a HTTP 404 response code otherwise.
   * <br/>This method calls twitter4j.Twitter.existsBlock(screenName) or existsBlock(userId)
   * <br/>existsBlock calls http://api.twitter.com/1/blocks/exists/[id].json
   *
   * @param screenName (optional) The screen_name of the potentially blocked user.
   * @param userId (optional) The ID of the potentially blocked user.
   * @return if the authenticating user is blocking a target user
   * @throws TwitterException when Twitter service or network is unavailable
   * @see <a href="https://dev.twitter.com/docs/api/1/get/blocks/exists">GET blocks/exists | Twitter Developers</a>
   * @since Twitter4S 1.0.0
   */
  def existsBlock(screenName: Option[String] = None, userId: Option[Long] = None): Boolean

  /**
   * Returns a list of user objects that the authenticating user is blocking.
   * <br/>This method calls twitter4j.Twitter.getBlockingUsers() or getBlockingUsers(page)
   * <br/>getBlockingUsers calls http://api.twitter.com/1/blocks/blocking.json
   *
   * @param page (optional) the number of page
   * @return a list of user objects that the authenticating user
   * @throws TwitterException when Twitter service or network is unavailable
   * @see <a href="https://dev.twitter.com/docs/api/1/get/blocks/blocking">GET blocks/blocking | Twitter Developers</a>
   * @since Twitter4S 1.0.0
   */
  def getBlockingUsers(page: Option[Int] = None): ResponseList[User]

  /**
   * Returns an array of numeric user ids the authenticating user is blocking.
   * <br/>This method calls twitter4j.Twitter.getBlockingUsersIDs
   * <br/>getBlockingUsersIDs calls http://api.twitter.com/1/blocks/blocking/ids
   *
   * @return Returns an array of numeric user ids the authenticating user is blocking.
   * @throws TwitterException when Twitter service or network is unavailable
   * @see <a href="https://dev.twitter.com/docs/api/1/get/blocks/blocking/ids">GET blocks/blocking/ids | Twitter Developers</a>
   * @since Twitter4S 1.0.0
   */
  def getBlockingUsersIDs: IDs
}