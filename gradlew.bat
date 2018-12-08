<?xml version="1.0" encoding="utf-8"?>
<!--
  ~ Copyright (C) 2016 The Android Open Source Project
  ~
  ~ Licensed under the Apache License, Version 2.0 (the "License");
  ~ you may not use this file except in compliance with the License.
  ~ You may obtain a copy of the License at
  ~
  ~      http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing, software
  ~ distributed under the License is distributed on an "AS IS" BASIS,
  ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  ~ See the License for the specific language governing permissions and
  ~ limitations under the License
  -->

<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="@dimen/notification_large_icon_width"
    android:layout_height="@dimen/notification_large_icon_height"
    android:id="@+id/icon_group"
>
    <ImageView android:id="@+id/icon"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginTop="@dimen/notification_big_circle_margin"
        android:layout_marginBottom="@dimen/notification_big_circle_margin"
        android:layout_marginStart="@dimen/notification_big_circle_margin"
        android:layout_marginEnd="@dimen/notification_big_circle_margin"
        android:scaleType="centerInside"
    />
    <ImageView android:id="@+id/right_icon"
        android:layout_width="@dimen/notification_right_icon_size"
        android:layout_height="@dimen/notification_right_icon_size"
        android:layout_gravity="end|bottom"
        android:scaleType="centerInside"
        android:visibility="gone"
        android:layout_marginEnd="8dp"
        android:layout_marginBottom="8dp"
    />
</FrameLayout>

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     