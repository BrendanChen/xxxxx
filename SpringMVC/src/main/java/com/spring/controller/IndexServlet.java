package com.spring.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.spring.entity.CookWayCodeVO;
import com.spring.entity.IngredientVO;
import com.spring.entity.KindCodeVO;
import com.spring.entity.RecipeVO;
import com.spring.entity.StepVO;
import com.spring.service.CookWayCodeService;
import com.spring.service.IngreService;
import com.spring.service.KindCodeService;
import com.spring.service.RcpService;
import com.spring.service.StepService;

@Controller
@RequestMapping("/")
public class IndexServlet extends AbstractController {

	@Autowired
	private KindCodeService kindCodeService;

	@Autowired
	private CookWayCodeService cookWayCodeService;

	@Autowired
	private RcpService rcpService;

	@Autowired
	private IngreService ingreService;

	@Autowired
	private StepService stepService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		return null;
	}

	@RequestMapping(value = "/")
	public String index() {
		return "redirect:/home";
	}

	@RequestMapping(value = "/home")
	ModelAndView initIndexPage() {

		ModelAndView model = new ModelAndView("index");

		// searchBar
		List<KindCodeVO> kindCodeList = kindCodeService.getAll();

		List<CookWayCodeVO> cookWayCodeList = cookWayCodeService.getAll();

		model.addObject("cookWayCodeList", cookWayCodeList);

		model.addObject("kindCodeList", kindCodeList);

		return model;
	}

	@RequestMapping(value = "/home/recipe.do")
	public ModelAndView findByCriteria(HttpServletRequest req, HttpServletResponse res)
			throws UnsupportedEncodingException {

		ModelAndView model = new ModelAndView("listOneRecipe");

		req.setCharacterEncoding("utf-8");

		Map map = req.getParameterMap();

		List<RecipeVO> list = rcpService.findByCriteria(map);

		List<List<IngredientVO>> ingredientList = new ArrayList<List<IngredientVO>>();

		if (list.size() != 0) {

			RecipeVO recipeVO = list.get(0);

			model.addObject("recipeVO", recipeVO);

			List<IngredientVO> countNumber = ingreService.findAllGroupByGroupNo(recipeVO.getRcpSeq());

			List<IngredientVO> groupList;

			for (int group_no = 1; group_no <= countNumber.size(); group_no++) {

				groupList = new ArrayList<IngredientVO>();

				List<IngredientVO> ingredientData = ingreService.findByGroupNo(recipeVO.getRcpSeq(), group_no);

				ingredientList.add(ingredientData);
			}

			model.addObject("ingredientList", ingredientList);

			// �d�ߨB�J
			List<StepVO> stepList = stepService.findByPrimaryKey(recipeVO.getRcpSeq());

			model.addObject("stepList", stepList);

			return model;
		}

		return model;
	}

	@RequestMapping(value = "/home/addRecipe")
	public String  createRecipe() {
		return "addRecipe";
	}
	
	
	@RequestMapping(value = "/facebook")
	ModelAndView getFacebookData() {

		ModelAndView model = new ModelAndView("");

		return model;
	}
	
	
}
