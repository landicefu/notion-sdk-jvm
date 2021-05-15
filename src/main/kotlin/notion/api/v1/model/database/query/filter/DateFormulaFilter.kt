package notion.api.v1.model.database.query.filter

data class DateFormulaFilter(
    override val equals: String? = null, // TODO: ISO 8601 date and time
    override val before: String? = null, // TODO: ISO 8601 date and time
    override val after: String? = null, // TODO: ISO 8601 date and time
    override val onOrBefore: String? = null, // TODO: ISO 8601 date and time
    override val onOrAfter: String? = null, // TODO: ISO 8601 date and time
    override val pastWeek: DateFilter.DateCondition? = null,
    override val pastMonth: DateFilter.DateCondition? = null,
    override val pastYear: DateFilter.DateCondition? = null,
    override val nextWeek: DateFilter.DateCondition? = null,
    override val nextMonth: DateFilter.DateCondition? = null,
    override val nextYear: DateFilter.DateCondition? = null,
    override val isEmpty: Boolean? = null,
    override val isNotEmpty: Boolean? = null,
) : QueryFilter, DateFilter