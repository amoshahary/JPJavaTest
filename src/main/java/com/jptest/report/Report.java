package com.jptest.report;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Report {
	private List<FinancialEntity> financialEntities;
	private static final String tableBorder = "+------+----------+----------+----------+----------+------------------+-----------------+-------+----------------+--------------------+%n";
	private static final String tableHeader = "| Rank |  Entity  | Buy/Sell | AgreedFx | Currency | Instruction Date | Settlement Date | Units | Price per unit | Trade Amount (USD) |%n";
	private static final String reportFormat = "| %4d | %-8s | %-8s | %,8.2f | %-8s | %-16s | %-15s | %5d | %,14.2f | %,18.2f |%n";

	public void buildReport() {
		String dateFormat = "dd MMM yyyy";

		adjustSettlementDates();
		sortEntities();
		setRankings();

		System.out.format(tableBorder);
		System.out.format(tableHeader);
		System.out.format(tableBorder);
		String prevBuySell = null;
		for (FinancialEntity entity : getFinancialEntities()) {
			if (prevBuySell == null || !prevBuySell.equals(entity.getBuySell())) {
				if (prevBuySell != null) {
					System.out.printf(tableBorder);
				}

				prevBuySell = entity.getBuySell();
				System.out.printf("| %-131s |%n", "B".equalsIgnoreCase(prevBuySell) ? "Outgoing: " : "Incoming: ");
				System.out.format(tableBorder);
			}

			System.out.printf(reportFormat, entity.getRank(), entity.getName(), entity.getBuySell(), entity.getAgreedFx(), 
					entity.getCurrency(), DateUtil.calendarToString(entity.getInstructionDate(), dateFormat), 
					DateUtil.calendarToString(entity.getSettlementDate(), dateFormat),  entity.getUnits(), 
					entity.getPricePerUnit(), entity.getTradeAmountInUSD());
		}
		System.out.format(tableBorder);
	}

	public void sortEntities() {
		Collections.sort(getFinancialEntities(), new Comparator<FinancialEntity>() {
			public int compare(FinancialEntity b1, FinancialEntity b2) {
				if (b1.getBuySell().compareTo(b2.getBuySell()) == 0) {
					return b1.getTradeAmountInUSD().compareTo(b2.getTradeAmountInUSD()) * (-1);
				} else {
					return b1.getBuySell().compareTo(b2.getBuySell());
				}
			}
		});
	}
	
	private void setRankings() {
		int rank = 0;
		String prevBuySell = null;
		BigDecimal prevTradeAmount = BigDecimal.ZERO;
		for (FinancialEntity entity : getFinancialEntities()) {
			if (prevBuySell == null || !prevBuySell.equals(entity.getBuySell())) {
				rank = 1;
				prevBuySell = entity.getBuySell();
				prevTradeAmount = entity.getTradeAmountInUSD();
			} else {
				if (entity.getTradeAmountInUSD().compareTo(prevTradeAmount) != 0) {
					rank++;
					prevTradeAmount = entity.getTradeAmountInUSD();
				}
			}

			entity.setRank(rank);
		}
	}

	public void adjustSettlementDates() {
		for (FinancialEntity entity : getFinancialEntities()) {
			if ("AED".equalsIgnoreCase(entity.getCurrency())
					|| "SAR".equalsIgnoreCase(entity.getCurrency())) {
				if (entity.getSettlementDate().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
					entity.getSettlementDate().add(Calendar.DATE, 2);
				} else if (entity.getSettlementDate().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
					entity.getSettlementDate().add(Calendar.DATE, 1);
				}
			} else {
				if (entity.getSettlementDate().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
					entity.getSettlementDate().add(Calendar.DATE, 2);
				} else if (entity.getSettlementDate().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
					entity.getSettlementDate().add(Calendar.DATE, 1);
				}
			}
		}
	}

	public List<FinancialEntity> getFinancialEntities() {
		return financialEntities;
	}

	public void setFinancialEntities(List<FinancialEntity> financialEntities) {
		this.financialEntities = financialEntities;
	}
}
