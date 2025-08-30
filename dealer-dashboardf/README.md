# Dealer Dashboard

Angular microfrontend for automotive parts dealers.

## Features

- Dealer login (simple, by dealer ID)
- View assigned orders
- Mark orders as fulfilled

## Development

```bash
npm install
npm start
# Visit http://localhost:4300/
```

## Production/Docker

```bash
npm run build
docker build -t dealer-dashboard .
docker run -p 4300:80 dealer-dashboard
```

## Testing

```bash
npm test
```