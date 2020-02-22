package com.example.demo.service;

import com.example.demo.models.Uoa;
import com.example.demo.models.UoaStatus;
import com.example.demo.models.UoaType;

public class VisitorPatternStatusType {
	public static final AbstractUoaStatus convert(UoaStatus status) {
		switch (status) {
			case Pending:
				return new PendingUoaStatus();
			case Active:
				return new ActiveUoaStatus();
			case Inactive:
				return new InactiveUoaStatus();
			default:
				return new DeletedUoaStatus();
		}
	}
	
	public static final AbstractUoaType convert(UoaType type) {
		switch (type) {
			case Currency:
				return new CurrencyUoaType();
			case Equity:
				return new EquityUoaType();
			case Physical:
				return new PhysicalUoaType();
			default:
				return new CountableUoaType();
		}
	}
	
	public static final String describes(Uoa uoa) {
		AbstractUoaStatus visitable = VisitorPatternStatusType.convert(uoa.getStatus());
		AbstractUoaType visitor = VisitorPatternStatusType.convert(uoa.getType());
		return visitable.describedBy(visitor, uoa);
	}
}

//====================
// statuses
//====================
abstract class AbstractUoaStatus {
	public abstract String describedBy(AbstractUoaType type, Uoa uoa);
}

final class PendingUoaStatus extends AbstractUoaStatus {
	public final String describedBy(AbstractUoaType type, Uoa uoa) {
		return type.describes(this, uoa);
	}
}

final class ActiveUoaStatus extends AbstractUoaStatus {
	public final String describedBy(AbstractUoaType type, Uoa uoa) {
		return type.describes(this, uoa);
	}
}

final class InactiveUoaStatus extends AbstractUoaStatus {
	public final String describedBy(AbstractUoaType type, Uoa uoa) {
		return type.describes(this, uoa);
	}
}

final class DeletedUoaStatus extends AbstractUoaStatus {
	public final String describedBy(AbstractUoaType type, Uoa uoa) {
		return type.describes(this, uoa);
	}
}

//====================
// types
//====================
abstract class AbstractUoaType {
	protected abstract String describes(PendingUoaStatus status, Uoa uoa);
	protected abstract String describes(ActiveUoaStatus status, Uoa uoa);
	protected abstract String describes(InactiveUoaStatus status, Uoa uoa);
	protected abstract String describes(DeletedUoaStatus status, Uoa uoa);
}

final class CurrencyUoaType extends AbstractUoaType {
	@Override
	protected String describes(PendingUoaStatus status, Uoa uoa) {
		return "A pending currency";
	}

	@Override
	protected String describes(ActiveUoaStatus status, Uoa uoa) {
		return "An active currency";
	}

	@Override
	protected String describes(InactiveUoaStatus status, Uoa uoa) {
		return "An inactive currency";
	}

	@Override
	protected String describes(DeletedUoaStatus status, Uoa uoa) {
		return "A deleted currency";
	}
}

final class EquityUoaType extends AbstractUoaType {

	@Override
	protected String describes(PendingUoaStatus status, Uoa uoa) {
		// TODO Auto-generated method stub
		return "A IPO share";
	}

	@Override
	protected String describes(ActiveUoaStatus status, Uoa uoa) {
		return "A trading share";
	}

	@Override
	protected String describes(InactiveUoaStatus status, Uoa uoa) {
		return "A suspended share";
	}

	@Override
	protected String describes(DeletedUoaStatus status, Uoa uoa) {
		return "An unlisted share";
	}
}

final class PhysicalUoaType extends AbstractUoaType {
	@Override
	protected String describes(PendingUoaStatus status, Uoa uoa) {
		return "An idea";
	}

	@Override
	protected String describes(ActiveUoaStatus status, Uoa uoa) {
		return "An object";
	}

	@Override
	protected String describes(InactiveUoaStatus status, Uoa uoa) {
		return "Broken pieces";
	}

	@Override
	protected String describes(DeletedUoaStatus status, Uoa uoa) {
		return "Ashes";
	}
}

final class CountableUoaType extends AbstractUoaType {
	@Override
	protected String describes(PendingUoaStatus status, Uoa uoa) {
		return "A request";
	}

	@Override
	protected String describes(ActiveUoaStatus status, Uoa uoa) {
		return "A deal";
	}

	@Override
	protected String describes(InactiveUoaStatus status, Uoa uoa) {
		return "A lawsuit";
	}

	@Override
	protected String describes(DeletedUoaStatus status, Uoa uoa) {
		return "A resentment";
	}
}