package twitter4s.dsl

/*
 * Copyright (C) 2013 Shinsuke Abe
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
import twitter4s.Twitter
import twitter4s.api.impl.DirectMessagesResourcesImpl

/**
 * @author mao.instantlife at gmail.com
 */
trait DirectMessagesResourcesDsl extends Twitter4sDslBase {
  type ResourcesType = DirectMessagesResourcesImpl
  protected val twitter4sResources = new Twitter(twitter4jResources) with ResourcesType
}
