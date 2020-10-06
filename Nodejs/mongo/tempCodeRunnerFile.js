[...Array(10).keys()].forEach(e => {
    console.log(e + 1000);
    createCourse(`node${e}`, `ishan${e}`, e * 1000);
});
