package com.example.demo.models;

import com.example.demo.service.VisitorPatternStatusType;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Uoa {
	private String code;
	private UoaStatus status;
	private UoaType type;
	
	public String getDescriptionByVisitor() {
		return VisitorPatternStatusType.describes(this);
	}
	
	public String getDescription() {
		switch (type) {
			case Currency:
				switch (status) {
					case Pending:
						return "A pending currency";
					case Active:
						return "An active currency";
					case Inactive:
						return "An inactive currency";
					case Deleted:
						return "A deleted currency";
					default:
						return "Unknown status";
				}
			case Equity:
				switch (status) {
					case Pending:
						return "A IPO share";
					case Active:
						return "A trading share";
					case Inactive:
						return "A suspended share";
					case Deleted:
						return "An unlisted share";
					default:
						return "Unknown status";
				}
			case Physical:
				switch (status) {
					case Pending:
						return "An idea";
					case Active:
						return "An object";
					case Inactive:
						return "Broken pieces";
					case Deleted:
						return "Ashes";
					default:
						return "Unknown status";
				}
			case Countable:
				switch (status) {
					case Pending:
						return "A request";
					case Active:
						return "A deal";
					case Inactive:
						return "A lawsuit";
					case Deleted:
						return "A resentment";
					default:
						return "Unknown status";
				}
			default:
				return "Unsupported type";
		}
	}
}
