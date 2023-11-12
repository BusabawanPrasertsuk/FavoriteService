# FavoriteService
### Path
* Get Book: (GET) /favorite-service/getBook
* Get Favorite: (GET) /favorite-service/getFavorite
* Add Favorite: (GET) /favorite-service/addFavorite
* Delete Favorite: (DELETE) /favorite-service/deleteFavorite/{BookId}
* Get BookById: (GET) /favorite-service/getBook/{BookId}
### RabbitMQ
* Get Book
  * Queues: GetBookQueue
  * Exchanges: FavoriteExchange
  * Routing key: getBook
* Get Favorite
  * Queues: GetFavoriteQueue
  * Exchanges: FavoriteExchange
  * Routing key: getFavorite
* Add Favorite
  * Queues: AddFavoriteQueue
  * Exchanges: FavoriteExchange
  * Routing key: addFavorite
* delete Favorite
  * Queues: DeleteFavoriteQueue
  * Exchanges: FavoriteExchange
  * Routing key: deleteFavorite
* get bookById
 * Queues: GetBookIdQueue
 * Exchanges: FavoriteExchange
 * Routing key: getBookId
