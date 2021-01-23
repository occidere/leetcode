object Solution {
  def filterRestaurants(restaurants: Array[Array[Int]], veganFriendly: Int, maxPrice: Int, maxDistance: Int): List[Int] =
    restaurants.filter(veganFriendly == 0 || _(2) == veganFriendly)
      .filter(x => x(3) <= maxPrice && x(4) <= maxDistance)
      .sortWith((x, y) => if (x(1) == y(1)) x.head > y.head else x(1) > y(1))
      .map(_.head)
      .toList
}