package io.prismic;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class PredicateTest {

  @Test
  public void testAtPredicate() {
    Predicate p = Predicates.at("document.type", "blog-post");
    Assert.assertEquals("[:d = at(document.type, \"blog-post\")]", p.q());
  }

  @Test
  public void testAnyPredicate() {
    Predicate p = Predicates.any("document.tags", Arrays.asList("Macaron", "Cupcakes"));
    Assert.assertEquals("[:d = any(document.tags, [\"Macaron\",\"Cupcakes\"])]", p.q());
  }

  @Test
  public void testNumberLT() {
    Predicate p = Predicates.lt("my.product.price", 4.2);
    Assert.assertEquals("[:d = number.lt(my.product.price, 4.2)]", p.q());
  }

  @Test
  public void testNumberInRange() {
    Predicate p = Predicates.inRange("my.product.price", 2, 4);
    Assert.assertEquals("[:d = number.inRange(my.product.price, 2.0, 4.0)]", p.q());
  }

  @Test
  public void testMonthAfter() {
    Predicate p = Predicates.monthAfter("my.blog-post.publication-date", Predicates.Month.APRIL);
    Assert.assertEquals("[:d = date.month-after(my.blog-post.publication-date, \"April\")]", p.q());
  }

  @Test
  public void testGeopointNear() {
    Predicate p = Predicates.near("my.store.coordinates", 40.689757, -74.0451453, 15);
    Assert.assertEquals("[:d = geopoint.near(my.store.coordinates, 40.689757, -74.0451453, 15)]", p.q());
  }

}
