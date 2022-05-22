/*
 * The APACHE License (APACHE)
 * 
 * Copyright (c) 2022 Author. All rights reserved.
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
package team.calistis.utils;

import cn.nukkit.item.Item;
import cn.nukkit.utils.BinaryStream;

public final class EncodingUtils {

  /**
   * this method encode a item into a byte array sequence
   * Usage: EncodingUtils.encodeItem(item) -> byte[]
   * @return byte[]
   */
  public static final byte[] encodeItem(Item item) {
    BinaryStream stream = new BinaryStream();
    stream.putSlot(item);
    return stream.getBuffer();
  }

  /**
   * this method decode an item of a byte array sequence
   * Usage: EncodingUtils.decodeItem(byte[]) -> Item
   * @return Item
   */
  public static final Item decodeItem(byte[] input) {
    BinaryStream stream = new BinaryStream(input);
    return stream.getSlot();
  }

}
