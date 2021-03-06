(function() {
	'use strict';

	angular.module('chasqui').controller('FormUsuarioController',
			FormUsuarioController);

	/**
	 * @ngInject Formulario para crear un grupo
	 */
	function FormUsuarioController($log, $state, restProxy, CTE_REST,ToastCommons,StateCommons,$scope) {
		$log.debug("controler FormUsuarioController",$scope.perfil);
		 
		var vm = this;

		vm.user = {};
		vm.passVerificacion;
		
		vm.isAlta=$scope.perfil != true;    // si crea un usuario nuevo o es un update. Si viene de perfil es UPDATE 
		vm.readOnly=! vm.isAlta; // si es alta siempre false, sino depende el modo.
		vm.isModoEdit = false; 
		
		vm.init = function (){
			if (! vm.isAlta){
				vm.callVerUsuario();
			}
		}

		vm.guardar = function() {
			vm.callGuardar();
		}
		
		vm.actualizar=function(){
			$log.debug("Actualizar usuario", vm.user);
			
			vm.callActualizarUsuario();
			
			vm.readOnly = true;
			vm.isModoEdit = false;
		}
		
		vm.edit = function (){
			$log.debug("click edit usuarrio");
			vm.readOnly = false;
			vm.isModoEdit = true;
		}
		
		vm.noActualizar=function (){
			$log.debug("click NO edit usuarrio");
			vm.readOnly = true;
			vm.isModoEdit = false;
		
			vm.callVerUsuario();
		}
		/////////// llamadas
		
		vm.callVerUsuario = function(){
			
			function doOk(response) {
				$log.debug("callVerUsuario");
				vm.user = response.data;
			}
		
			// TODO : manejar error
			restProxy.get(CTE_REST.verUsuario, {}, doOk);
		}
		
		vm.callActualizarUsuario = function(){
			
			function doOk(response) {				 
				ToastCommons.mensaje('Se actualizo con exito');
			}
		
			// TODO : manejar error
			restProxy.put(CTE_REST.editUsuario, vm.user, doOk);
		}
		
		// usuaruo nuevo
		vm.callGuardar = function() {
			$log.debug("guardar usuario", vm.user);

			if (vm.user.password == vm.passVerificacion) {

				function doOk(response) {
					$log.debug("guardo usuario", response.data);
					ToastCommons.mensaje('Bienvenido');
					
					StateCommons.ls.token = response.data.token;
					
					//$state.go("registro",{ "isPasoDomicilio" : true});
					//$rootScope.$broadcast("creo-usuario-nuevo", { user: response.data });
					$scope.$emit("creo-usuario-nuevo", { user: response.data });
					
				}
			
				// TODO : manejar error
				restProxy.post(CTE_REST.singUp, vm.user, doOk);
			}else{
				$log.error("las contrasenas no coinciden");
				//TODO: enviar mensaje
				ToastCommons.mensaje('Las contrasenias no coinciden')
			}
		}
		
		vm.init();
	}

})();