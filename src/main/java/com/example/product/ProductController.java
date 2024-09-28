@RestController
public class ProductController {
    private final ALProductService alProductService;
    private final UpdateProductService updateProductService;
    private final GetProductService getProductService;

    public ProductController(ALProductService alProductService,
                             CreateProductService createProductService,
                             UpdateProductService updateProductService,
                             GetProductService getProductService) {
        this.alProductService = alProductService;
        this.createProductService = createProductService;
        this.updateProductService = updateProductService;
        this.getProductService = getProductService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ProductDto productDto) {
        return createProductService.execute(productDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> obtain(@PathVariable Integer id) {
        return this.getProductService.execute(id);
    }

    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
    }

    @PutMapping
    public ResponseEntity<List<ProductDto>> update(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        return updateProductService.execute(new UpdateProduct(id, productDto));
    }

    @GetMapping("all")
    public ResponseEntity<List<ProductDto>> index() {
        return this.alProductService.execute(input null);
    }
}