package net.sam.dcl.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "dcl_commercial_proposal")
public class CommercialProposalEntity {

    @Id
    @Column(name = "cpr_id", nullable = false)
    private Integer id;

    @Column(name = "cpr_create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "usr_id_create", nullable = false)
    private Integer createUserId;

    @Column(name = "cpr_edit_date", nullable = false)
    private LocalDateTime editDate;

    @Column(name = "usr_id_edit", nullable = false)
    private Integer editUserId;

    @Column(name = "cpr_number", nullable = false, length = 20)
    private String number;

    @Column(name = "cpr_date", nullable = false)
    private LocalDate date;

    @Column(name = "ctr_id", nullable = false)
    private Integer contractorId;

    @Column(name = "cpr_concerning", length = 1000)
    private String concerning;

    @Column(name = "cpr_preamble", length = 1000)
    private String preamble;

    @Column(name = "cur_id", nullable = false)
    private Integer currencyId;

    @Column(name = "cpr_course", precision = 18, scale = 8)
    private BigDecimal course;

    @Column(name = "cpr_nds", precision = 15, scale = 2)
    private BigDecimal nds;

    @Column(name = "trm_id_price_condition", nullable = false)
    private Integer priceConditionId;

    @Column(name = "cpr_country", length = 32)
    private String country;

    @Column(name = "cpr_pay_condition", length = 1000)
    private String payCondition;

    @Column(name = "trm_id_delivery_condition", nullable = false)
    private Integer deliveryConditionId;

    @Column(name = "cpr_delivery_address", length = 256)
    private String deliveryAddress;

    @Column(name = "cpr_sum_transport", precision = 15, scale = 2)
    private BigDecimal sumTransport;

    @Column(name = "cpr_delivery_term", length = 2000)
    private String deliveryTerm;

    @Column(name = "cpr_add_info", length = 3000)
    private String addInfo;

    @Column(name = "cpr_final_date")
    private LocalDate finalDate;

    @Column(name = "usr_id")
    private Integer userId;

    @Column(name = "cpr_proposal_received_flag")
    private Short proposalReceivedFlag;

    @Column(name = "cpr_date_accept")
    private LocalDate dateAccept;

    @Column(name = "cpr_block")
    private Short block;

    @Column(name = "cpr_img_name", length = 20)
    private String imageName;

    @Column(name = "cpr_summ", precision = 15, scale = 2)
    private BigDecimal summary;

    @Column(name = "cps_id")
    private Integer contactPersonId;

    @Column(name = "cpr_nds_by_string")
    private Short ndsByString;

    @Column(name = "cpr_sum_assembling", precision = 15, scale = 2)
    private BigDecimal sumAssembling;

    @Column(name = "cpr_old_version")
    private Short oldVersion;

    @Column(name = "cpr_check_price")
    private Short checkPrice;

    @Column(name = "cpr_check_price_date")
    private LocalDateTime checkPriceDate;

    @Column(name = "usr_id_check_price")
    private Integer checkPriceUserId;

    @Column(name = "cur_id_table", nullable = false)
    private Integer tableCurrencyId;

    @Column(name = "cpr_assemble_minsk_store")
    private Short assembleMinskStore;

    @Column(name = "bln_id", nullable = false)
    private Integer blankId;

    @Column(name = "cpr_all_transport")
    private Short allTransport;

    @Column(name = "cpr_concerning_invoice", length = 1000)
    private String concerningInvoice;

    @Column(name = "cpr_can_edit_invoice")
    private Short canEditInvoice;

    @Column(name = "cpr_pay_condition_invoice", length = 1000)
    private String payConditionInvoice;

    @Column(name = "cpr_delivery_term_invoice", length = 2000)
    private String deliveryTermInvoice;

    @Column(name = "cpr_final_date_invoice", length = 30)
    private String finalDateInvoice;

    @Column(name = "cpr_comment", length = 3000)
    private String comment;

    @Column(name = "executor_id")
    private Integer executorId;

    @Column(name = "cpr_executor_flag")
    private Short executorFlag;

    @Column(name = "pps_id")
    private Integer purchasePurposeId;

    @Column(name = "cpr_reverse_calc")
    private Short reverseCalc;

    @Column(name = "cps_id_seller")
    private Integer sellerContactPersonId;

    @Column(name = "cps_id_customer")
    private Integer customerContactPersonId;

    @Column(name = "cpr_prepay_percent", precision = 15, scale = 2)
    private BigDecimal prepayPercent;

    @Column(name = "cpr_prepay_sum", precision = 15, scale = 2)
    private BigDecimal prepaySum;

    @Column(name = "cpr_delay_days")
    private Integer delayDays;

    @Column(name = "cpr_no_reservation")
    private Short noReservation;

    @Column(name = "cpr_provider_delivery")
    private Short providerDelivery;

    @Column(name = "cpr_provider_delivery_address", length = 500)
    private String providerDeliveryAddress;

    @Column(name = "cpr_delivery_count_day")
    private Integer deliveryCountDay;

    @Column(name = "cpr_free_prices")
    private Short freePrices;

    @Column(name = "cpr_donot_calculate_netto")
    private Short doNotCalculateNetto;

    @Column(name = "cpr_print_scale")
    private Integer printScale;

    @Column(name = "cpr_contract_scale")
    private Integer contractScale;

    @Column(name = "cpr_invoice_scale")
    private Integer invoiceScale;

    @Column(name = "cpr_guaranty_in_month")
    private Integer guarantyInMonth;

    @Column(name = "ctr_id_consignee")
    private Integer consigneeId;

    @Column(name = "cpr_final_date_above")
    private Short finalDateAbove;

    @Column(name = "cpr_tender_number", length = 100)
    private String tenderNumber;

    @Column(name = "cpr_tender_number_editable", nullable = false, length = 1)
    private String tenderNumberEditable;

    @Column(name = "cpr_proposal_declined", nullable = false, length = 1)
    private String proposalDeclined;
}
