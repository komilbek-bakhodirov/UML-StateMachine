package lnf

import lnf.Location.Stadtmitte

case class Item(description: String, location: Location) {
  def box(n: Int): String =
    if (description.length < n)
      s"[${description.padTo(n, ' ')}]"
    else if (description.length == n)
      s"[$description]"
    else
      s"[${description.take(n)}]"
}

case object Item {
  def apply(): Item = Item("Generic", Stadtmitte)
}