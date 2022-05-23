package third.laboratoy.exam;

 class CartoonChecker {

	public static void processCharacter(String name) {
		String[] polje = Pepa.getAllCharacters();
		for(String names : polje) {
			if(names.equals(name)) {
				System.out.println(name +  " JE lik u crtanom filmu Peppa Pig");
				return;
			}
		}
		throw new InvalidPeppaPigCharacterException(name + " NIJE lik u crtanom filmu Peppa Pig");
	}
}
