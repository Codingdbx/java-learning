package interfaceandInheritance.defaultexample;

import java.util.Comparator;

/**
 * Comparator是比较器，我们若需要控制某个类的次序，可以建立一个“该类的比较器”来进行排序。
 *
 * created by dbx on 2019/3/9
 */
public class SortByRankThenSuit implements Comparator<Card> {

    public int compare(Card firstCard, Card secondCard) {
        int compVal = firstCard.getRank().value() - secondCard.getRank().value();
        if (compVal != 0)
            return compVal;
        else
            return firstCard.getSuit().value() - secondCard.getSuit().value();
    }
}