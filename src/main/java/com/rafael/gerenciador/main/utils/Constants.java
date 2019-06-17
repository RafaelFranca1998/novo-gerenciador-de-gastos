package com.rafael.gerenciador.main.utils;

public interface Constants {
	
	interface Date {
		public static final String DATE_PATTERN = "dd/MM/yyyy";
		public static final String DATE_PATTERN_MM_YYYY = "MM/yyyy";
		public static final String DATE_PATTERN_MMM_YYYY = "MMM - yyyy";
		public static final String DATE_PATTERN_MMMM_YYYY = "MMMM - yyyy";
		public static final String DATE_PATTERN_YYYY = "yyyy";
		public static final String DATE_PATTERN_DD = "dd";
		public static final String DATE_PATTERN_DATE_TIME = "yyyy-MM-dd HH:mm";
		public static final String DATE_PATTERN_CHART = "yyyy-MM-dd";
	}
	
	interface Language {
		public static final String LINGUAGEM_PT_BR = "pt_BR";
		public static final String LINGUAGEM_ES_ES = "es_ES";
		public static final String LINGUAGEM_EN_US = "en_US";
	}
	
	interface Color {
		public static final String AQUA_RGB = "#00c0ef";
		public static final String BLUE_RGB = "#3c8dbc";
		public static final String GREEN_RGB = "#00a65a";
		public static final String YELLOW_RGB = "#f39c12";
		public static final String RED_RGB = "#dd4b39";
	}
	
	interface ProjectStatus {
		public static final Long DRAFT = 60L;
		public static final Long IN_FIELD = 19L;
		public static final Long ON_HOLD = 51L;
		public static final Long DATA_CHECK = 43L;
		public static final Long INCENTIVE = 44L;
		public static final Long CLOSED = 78L;
		public static final Long REJECTED = 81L;
		public static final Long CANCELED = 85L;
	}
	
	interface ContactStatus {
		public static final Long NEW = 1L;
		public static final Long APPROVED = 2L;
		public static final Long RESERVED = 3L;
		public static final Long CLOSED = 4L;
		public static final Long PAUSED = 6L;
		public static final Long SAMPLE_EXHAUSTED = 9L;
		public static final Long ERROR = 10L;
	}
	
	interface ContactType {
		public static final Long EMAIL = 9L;
		public static final Long IMPORTED = 4L;
		public static final Long MOBILE = 16L;
		public static final Long TEST = 17L;
		public static final Long REDIRECT = 18L;
		public static final Long SMS = 20L;
	}
	
	interface PersonType {
		public static final Long CLIENT = new Long(7);
	}
	
	interface Panel {
		public static final Long ECGLOBAL_NET = new Long(265);
		public static final Long ECGLOBAL_PANEL = new Long(1);
	}
	
	interface Security {
		public static final String USER_LOGIN = "UserSecurity";
	}
	
	interface FeedbackJobStatus {
		public static final Long APPROVED_JOB = 1L;
		public static final Long NEW_PROJECT_CREATED = 2L;
		public static final Long NO_SCHEDULED_JOBS = 3L;
	}

}
