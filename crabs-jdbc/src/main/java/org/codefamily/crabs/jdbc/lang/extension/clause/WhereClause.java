package org.codefamily.crabs.jdbc.lang.extension.clause;

import org.codefamily.crabs.util.ReadonlyList;
import org.codefamily.crabs.jdbc.lang.Clause;
import org.codefamily.crabs.jdbc.lang.Expression;
import org.codefamily.crabs.jdbc.lang.Keyword;
import org.codefamily.crabs.jdbc.lang.extension.ReservedKeyword;

public final class WhereClause extends Clause {

    public static final ReadonlyList<Keyword> PREFIX_KEYWORD_LIST
            = ReadonlyList.newInstance((Keyword) ReservedKeyword.WHERE);

    public WhereClause(final Expression expression) {
        super(PREFIX_KEYWORD_LIST);
        if (expression == null) {
            throw new IllegalArgumentException("Argument[expressions] is null.");
        }
        this.conditionExpression = expression;
    }

    public final Expression conditionExpression;

    @Override
    public final String toString() {
        return this.getPrefixKeywordsString() + " "
                + this.conditionExpression.toString();
    }

    @Override
    public final boolean equals(final Object object) {
        if (object != null && object instanceof WhereClause) {
            if (object == this) {
                return true;
            }
            final WhereClause that = (WhereClause) object;
            return this.conditionExpression.equals(that.conditionExpression);
        }
        return false;
    }

}
