# 1. Cloner le projet
git clone https://github.com/Iccecube/SpringDataRest.git
cd SpringDataRest

# 2. Démarrer tous les services (le .env est déjà inclus)
docker compose up -d

# 3. Vérifier le statut
docker ps

🌐 URLs d'accès :
Service	URL
Frontend React	http://localhost:3000
Backend API	http://localhost:8080/api
Prometheus	http://localhost:9091
Grafana	http://localhost:3001
MySQL	localhost:3307
Identifiants Grafana : admin / admin