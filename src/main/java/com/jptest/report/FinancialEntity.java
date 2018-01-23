package com.jptest.report;

import java.math.BigDecimal;
import java.util.Calendar;

public class FinancialEntity {
	private String name;
	private String buySell;
	private BigDecimal agreedFx;
	private String currency;
	private Calendar instructionDate;
	private Calendar settlementDate;
	private int units;
	private BigDecimal pricePerUnit;
	private int rank;

	public FinancialEntity(String name, String buySell, BigDecimal agreedFx, 
			String currency, Calendar instructionDate,
			Calendar settlementDate, int units, BigDecimal pricePerUnit) {
		this.name = name;
		this.buySell = buySell;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.units = units;
		this.pricePerUnit = pricePerUnit;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}

	public String getBuySell() {
		return buySell;
	}

	public void setAgreedFx(BigDecimal agreedFx) {
		this.agreedFx = agreedFx;
	}

	public BigDecimal getAgreedFx() {
		return agreedFx;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrency() {
		return currency;
	}

	public void setInstructionDate(Calendar instructionDate) {
		this.instructionDate = instructionDate;
	}

	public Calendar getInstructionDate() {
		return instructionDate;
	}

	public void setSettlementDate(Calendar settlementDate) {
		this.settlementDate = settlementDate;
	}

	public Calendar getSettlementDate() {
		return settlementDate;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public int getUnits() {
		return units;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public BigDecimal getTradeAmountInUSD() {
		return pricePerUnit.multiply(BigDecimal.valueOf(units)).multiply(agreedFx);
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agreedFx == null) ? 0 : agreedFx.hashCode());
		result = prime * result + ((buySell == null) ? 0 : buySell.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((instructionDate == null) ? 0 : instructionDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pricePerUnit == null) ? 0 : pricePerUnit.hashCode());
		result = prime * result + rank;
		result = prime * result + ((settlementDate == null) ? 0 : settlementDate.hashCode());
		result = prime * result + units;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		FinancialEntity other = (FinancialEntity) obj;
		if (agreedFx == null) {
			if (other.agreedFx != null)
				return false;
		} else if (!agreedFx.equals(other.agreedFx)) {
			return false;
		}
		if (buySell == null) {
			if (other.buySell != null)
				return false;
		} else if (!buySell.equals(other.buySell)) {
			return false;
		}
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency)) {
			return false;
		}
		if (instructionDate == null) {
			if (other.instructionDate != null)
				return false;
		} else if (!instructionDate.equals(other.instructionDate)) {
			return false;
		}
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (pricePerUnit == null) {
			if (other.pricePerUnit != null) {
				return false;
			}
		} else if (!pricePerUnit.equals(other.pricePerUnit)) {
			return false;
		}
		if (rank != other.rank) {
			return false;
		}
		if (settlementDate == null) {
			if (other.settlementDate != null) {
				return false;
			}
		} else if (!settlementDate.equals(other.settlementDate)) {
			return false;
		}
		if (units != other.units) {
			return false;
		}
		return true;
	}
}