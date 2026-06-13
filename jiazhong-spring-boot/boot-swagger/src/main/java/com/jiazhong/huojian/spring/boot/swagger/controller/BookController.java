package com.jiazhong.huojian.spring.boot.swagger.controller;

import com.jiazhong.huojian.commons.JsonResult;
import com.jiazhong.huojian.commons.ResultTool;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@Tag(name = "BookController", description = "图书访问接口")
public class BookController {
    @Operation(description = "图书的全查询接口 API")
    @GetMapping
    public JsonResult find() {
        return ResultTool.success("返回所有图书");
    }

    @Operation(
            description = "图书的逻辑删除接口 API",
            summary = "图书删除",
            parameters = @Parameter(
                    name = "id", description = "需要删除的图书 id", required = true
            ),
            responses = {
                    @ApiResponse(description = "成功返回",
                            content = {@Content(mediaType = "application/json")}),
                    @ApiResponse(description = "失败返回")
            }
    )
    @DeleteMapping("/{id}")
    public JsonResult remove(@PathVariable int id) {
        if (id == 1) {
            return ResultTool.fail(501, "ID不能为1");
        }
        return ResultTool.success("success");
    }

}
