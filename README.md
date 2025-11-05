**https://developer.hashicorp.com/vault/tutorials/encryption-as-a-service/eaas-spring-demo**

https://developer.hashicorp.com/vault/install

**Download & Start:**

On brand new Vault without any existing data, start the initialize Vault by running:

$ vault operator init

$ vault server -dev (automatic token)
$ vault server -dev -dev-root-token-id devroot (with devroot as token).

default:
$ set VAULT_DEV_LISTEN_ADDRESS=127.0.0.1:8200

**(Optional)**
**SSL**
$ set VAULT_CACERT='/var/folders/qr/zgztx0sj6n1dxy86sl36ntnw0000gn/T/vault-tls3037226588/vault-ca.pem'

To Start a Vault dev server with the literal string root as the root token value, and enable TLS:
vault server -dev -dev-root-token-id root -dev-tls

LOCAL:
$ vault server -dev -dev-root-token-id devroot

At runtime, the dev server also automatically unseals, and prints the "unseal key" and "initial root token" values to the standard output

Once vault started, it will show the UnSeal key like below:
Unseal Key: MEFP57Q/67BiU/zLRLHXXvbWGHaQyn+xMdL3JmdMQ+E=
Root Token: devroot

Open another terminal:
$ set VAULT_ADDR=http://127.0.0.1:8200

$ vault status

To login:
vault login
Enter token now to login: **devroot**

**To add secrets to vault:**
vault kv put secret/myapp username=demoUser password=superSecret123

To get value using vault command:
vault kv get -mount="secret" "myapp" (OR)
vault kv get secret/myapp

To list all vaults:
vault secrets list

**Test the endpoints:**
Read secret:
GET http://localhost:8080/secrets/myapp
 where /secrets/ is the REST endpoint prefix & myapp is the path in the vault. 

Write secret:
POST http://localhost:8080/secrets/myapp
 where /secrets/ is the REST endpoint prefix & myapp is the path in the vault.
 
Body:
{
  "username": "user2",
  "password": "newpass"
}
