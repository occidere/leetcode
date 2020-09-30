import scala.collection.mutable

object Solution {
  def accountsMerge(accounts: List[List[String]]): List[List[String]] = {
    val parent = mutable.Map[String, String]()
    val owner = mutable.Map[String, String]()

    def find(email: String): String = {
      if (parent(email) != email) parent(email) = find(parent(email))
      parent(email)
    }

    def union(a: String, b: String): Unit = parent(find(a)) = find(b)

    accounts.foreach(account => {
      val name = account.head
      val root = account.tail.head
      account.tail.foreach(email => {
        if (!parent.contains(email)) parent(email) = email
        owner(email) = name
        union(email, root)
      })
    })

    parent.keys
      .groupMap(find)(email => email)
      .map(emails => owner(emails._1) +: emails._2.toList.sorted)
      .toList
  }
}