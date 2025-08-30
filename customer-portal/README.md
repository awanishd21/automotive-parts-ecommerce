# Customer Portal

Angular microfrontend for the Automotive Parts Ecommerce demo.

## Features

- Search for parts by name and city
- View nearby dealers
- Place orders (choose dealer or auto-assign)
- Dockerized for easy deployment

## Development

```bash
npm install
npm start
# Visit http://localhost:4200/
```

## Production/Docker

```bash
npm run build
docker build -t customer-portal .
docker run -p 4200:80 customer-portal
```

## Testing

```bash
npm test
```