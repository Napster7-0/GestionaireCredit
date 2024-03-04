## GettingCredit.java

C'est la classe finale utilisée dans l'ensemble de l'application java.

## GetCredit.java

C'est la racine même de la structure de la classe finale.
Elle implemente une classe abstraite **GetCredit** et ses classes filles concrètes **GetCredit1**, **GetCredit2**, **GetCredit3**, **GetCredit4**.
La dernière classe **GetCredit4** contient donc les méthodes finales dont heriterons la classe principale **GettingCredit**.

Ces méthodes sont:
- **public long maxCredit(int age, long salaire)**  
Elle permet de determiner à quelle catégorie vous appartenez(Credit Minime, Junior, ...) et retourne le max que vous pouvez emprunter(1 000 000, 2 000 000, ...)
- **public String infoCredit()**
Vous donne plus de détails sur votre catégorie et votre elligibilité au Crédit.
- **public String GettingACredit(long mont)**
Elle permet de mettre à  jour vos paramètres pour savoir si oui ou non vous pouvez effectuer un Crédit.

Ces attributs sont:
- protected long salaire;
- protected int age;
- protected boolean canGetCredit;
- protected String categorie;

## public long maxCredit(int age, long salaire)

C'est le coeur du fonctionnement.
Lorsque le user entre ses paramètres(age et salaire), cette fonction commence par le tester pour la 4e Categorie de prêt qui est la catégorie Crédit Gold, si le client est dans la tranche **age < 55** sachant de façon implicite que son **salaire > 300000** et que son **age > 45** , il est renvoyé à la catégorie inférieure. Pareil si ce dernier a un **salaire <= 300000**. Et ainsi de suite.