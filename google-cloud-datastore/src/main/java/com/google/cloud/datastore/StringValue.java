/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastore;

import static com.google.datastore.v1.Value.STRING_VALUE_FIELD_NUMBER;

public final class StringValue extends Value<String> {

  private static final long serialVersionUID = -8709280401468276732L;

  static final BaseMarshaller<String, StringValue, Builder> MARSHALLER =
      new BaseMarshaller<String, StringValue, Builder>() {

        private static final long serialVersionUID = -635109599283869091L;

        @Override
        public int getProtoFieldId() {
          return STRING_VALUE_FIELD_NUMBER;
        }

        @Override
        public Builder newBuilder(String value) {
          return StringValue.newBuilder(value);
        }

        @Override
        protected String getValue(com.google.datastore.v1.Value from) {
          return from.getStringValue();
        }

        @Override
        protected void setValue(StringValue from, com.google.datastore.v1.Value.Builder to) {
          to.setStringValue(from.get());
        }
      };

  public static final class Builder extends Value.BaseBuilder<String, StringValue, Builder> {

    private Builder() {
      super(ValueType.STRING);
    }

    @Override
    public StringValue build() {
      return new StringValue(this);
    }
  }

  public StringValue(String value) {
    this(newBuilder(value));
  }

  private StringValue(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static StringValue of(String value) {
    return new StringValue(value);
  }


  public static Builder newBuilder(String value) {
    return new Builder().set(value);
  }
}
