package com.tasks.utils;

import java.util.UUID;

public final class TaskUtils {
	private TaskUtils(){}
	
	public static String getUniqueRef() {
		return UUID.randomUUID().toString();
	}
}
