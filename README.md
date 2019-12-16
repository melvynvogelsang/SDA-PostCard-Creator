# SDA-PostCard-Creator
Un utilisateur choisi s’il veut envoyer une carte en format physique (par la poste) OU format électronique par email. Un utilisateur est identifié par son email.
Seul un utilisateur peut envoyer une carte. Mais n’importe qui peut la recevoir. 

##Actions de stockage : 
Les utilisateurs sont stockés dans une hash map (email hashé/nb colonnes map = trouve la linked list correspondante)
LinkedList d’Utilisateurs. 
On a donc des bucket d’utilisateurs qui eux même on 2 arrayLists : 
1. cartesEnvoyes
2. cartesRecues

###Cas envoi électronique : 
Demande l’adresse email du destinataire puis envoi par email la carte. 
Ajoute la carte dans l’ArrayList cartesEnvoyes de l’envoyeur. 
Si l’adresse email du destinataire correspond à celle d’un utilisateur : ajoute cette carte a l’ArrayList  carteRecues de l’utilisateur destinataire. 

###Cas envoi physique :
Spécifie l’adresse, nom, prénom du destinataire : créé un objet commande qui sera reçu par le système de poste et enverra la carte postale.  Ajoute cette carte à  l’ArrayList de l’utilisateur :cartesEnvoye
2 -ème action : demande a l’utilisateur s’il veut également envoyer cette même carte au format électronique, si oui « cas envoi électronique ».



