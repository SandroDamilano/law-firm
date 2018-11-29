class ParticularPermission(permittedCase: Case) extends Permission {

  override def allowsAccessTo(aCase: Case): Boolean = {
    aCase.equals(permittedCase)
  }
}
