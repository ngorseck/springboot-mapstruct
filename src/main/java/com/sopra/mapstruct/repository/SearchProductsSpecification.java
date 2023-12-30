package com.sopra.mapstruct.repository;

import com.sopra.mapstruct.entities.ProductsEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchProductsSpecification {
  private static final String USER = "usersEntity";

  /**
   * List<DepotCIEntity> depots = new ArrayList<>();
   *  Session session = this.recupererHibernateSession();
   *  CriteriaBuilder cb = session.getCriteriaBuilder();
   *  CriteriaQuery<DepotCIEntity> cq = cb.createQuery(DepotCIEntity.class);
   *  Root<DepotCIEntity> root = cq.from(DepotCIEntity.class);
   *
   *  //Creation d'une liste de predicat pour tester chaque numero de declaration
   *  List<Predicate> predicates = new ArrayList<>();
   *  predicates.add(cb.equal(root.get("codeApplicationSource"), codeApplicationSource));
   *  predicates.add(root.get(NO_DECLARATION).in(noDeclarations));
   *  cq.where(predicates.toArray(Predicate[]::new));
   *  depots = session.createQuery(cq).getResultList();
   * @return
   */
  public static Specification<ProductsEntity> select() {
    //cq : CriteriaQuery<T> is for SELECT, FROM, WHERE
    //cb : CriteriaBuilder is for or, and, equal, like,
    return (products, cq, cb) -> {

      // Set the DISTINCT flag
      cq.distinct(true);

      // Apply sorting
      cq.orderBy(cb.desc(products.get("usersEntity")));

      return null;
    };
  }

  protected static Specification<ProductsEntity> containsLabel(String input) {
    //cq is for SELECT, FROM, WHERE
    return (products, cq, cb) -> cb.like(cb.lower(products.get(USER).get("fullName")),
            "%" + input.toLowerCase() + "%");

  }
}
