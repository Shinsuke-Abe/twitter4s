package twitter4s.internal.json
/*
 * Copyright (C) 2012 Shinsuke Abe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import twitter4s.IDs
import twitter4s.AccessLevel

/**
 * @author Shinsuke Abe - mao.instantlife at gmail.com
 */
case class IDsImpl(twt4jIDs: twitter4j.IDs) extends IDs {
  type Tw4jResponse = twitter4j.IDs

  def ids = twt4jIDs.getIDs()

  def hasPrevious = twt4jIDs.hasPrevious()

  def previousCursor = twt4jIDs.getPreviousCursor()

  def hasNext = twt4jIDs.hasNext()

  def nextCursor = twt4jIDs.getNextCursor()
  
  def rateLimitStatus = RateLimitStatusImpl(twt4jIDs.getRateLimitStatus())
  
  def accessLevel = AccessLevel(twt4jIDs.getAccessLevel())
  
  def tw4jObj = twt4jIDs

  def apply(idx: Int) = ids(idx)
}