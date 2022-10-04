fetch('https://jsonplaceholder.typicode.com/users', {
  headers: {
    'Content-type': 'application/json'
  },
  method: 'POST',
  body: JSON.stringify({ id: 11, name: 'Rodrigo Díaz de Vivar', username: 'El Cid' })
  })
  .then((response) => {
    document.getElementById('maru').value = "Yesik";
    console.log(response)
    response.json()
  });