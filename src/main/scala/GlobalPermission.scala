class GlobalPermission(lawyer: Lawyer) extends Permission {

  override def allowsAccessTo(aCase: Case): Boolean = {
    aCase.owner.equals(lawyer)
  }

}
