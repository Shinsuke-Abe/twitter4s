package twitter4s
import twitter4j.GeoLocation
import twitter4j.Place
import java.util.Date

/**
 * @author Shinsuke Abe - mao.instantlife at gmail.com
 */
trait Twt {
  def createdAt: Date
  
  def id: Long
  
  def text: String
  
  def source: String
  
  def inReplyToStatusId: Long
  
  def place: Place
  
  def geoLocation: GeoLocation
}