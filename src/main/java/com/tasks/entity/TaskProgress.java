package com.tasks.entity;

import java.time.ZonedDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaskProgress {
	String progressId;
	String progressMade;
	String madeBy;
	ZonedDateTime madeAt;
}
