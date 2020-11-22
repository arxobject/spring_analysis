package com.ninjutsu.xml.util;

import com.sun.istack.internal.Nullable;

//声明成abstract 并免其new 出个对象来 浪费gc 浪费内存资源
public abstract class StringUtils{
	public static boolean hasLength(@Nullable String str) {
		return (str != null && !str.isEmpty());
	}

	public static boolean isNullOrEmpty(@Nullable Object str) {
		return (str == null || "".equals(str));
	}
}